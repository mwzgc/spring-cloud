
package com.mwz.v1.config;

import io.sentry.SentryClient;
import io.sentry.context.Context;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @Autowired
    private SentryClient sentry;

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnknownException(RuntimeException e) {
//        log.error("运行异常", e);

        // Retrieve the current context.
        Context context = sentry.getContext();
        // Record a breadcrumb in the current context. By default the last 100 breadcrumbs are kept.
        context.recordBreadcrumb(new BreadcrumbBuilder().setMessage("User made an action").build());
        // Set the user in the current context.
        context.setUser(new UserBuilder().setEmail("546591791@qq.com").build());
        // This sends a simple event to Sentry.
        sentry.sendMessage("Exception");
        sentry.sendException(e);

        return "error";
    }

}

