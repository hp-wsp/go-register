package com.ts.server.mask.controller.interceptor;

import com.ts.server.mask.BaseException;
import com.ts.server.mask.security.Credential;
import com.ts.server.mask.security.CredentialContextUtils;
import com.ts.server.mask.security.token.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * 基础权限认证拦截器
 *
 * @author TS Group
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    private final TokenService service;

    public AuthorizationInterceptor(TokenService service) {
        this.service = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {

        Optional<String> optional = getToken(request);
        if(!optional.isPresent()){
            responseForbid(response);
            return  false;
        }

        Optional<Credential> credential = validateAndGet(optional.get());
        if(!credential.isPresent()){
            responseForbid(response);
            return  false;
        }

        CredentialContextUtils.setCredential(credential.get());
        return true;
    }

    private Optional<String> getToken(HttpServletRequest request){
        Optional<String> optional = Optional.ofNullable(request.getHeader("token"));
        if(optional.isPresent()){
            return optional;
        }
        optional = Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .map(e -> StringUtils.removeStart(e, "Bearer"))
                .map(StringUtils::trim);
        if(optional.isPresent()){
            return optional;
        }

        return Optional.ofNullable(request.getParameter("token"));
    }

    private Optional<Credential> validateAndGet(String token){
        try{
            return Optional.of(service.validateAndGet(token));
        }catch (BaseException e){
            LOGGER.error("Get token not exist token={}", token);
            return Optional.empty();
        }
    }

    /**
     * 输出禁止访问信息到客户端
     *
     * @param response    {@link HttpServletResponse}
     * @throws IOException
     */
    private void responseForbid(HttpServletResponse response)throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().append("{\"code\":410, \"messages\":[\"access forbid\"]}");
        response.getWriter().flush();
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        CredentialContextUtils.setCredential(null);
    }
}
