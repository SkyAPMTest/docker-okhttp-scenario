package org.skywalking.apm.testcase.okhttp.controller;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaseController {

    private final OkHttpClient client = new OkHttpClient();

    @RequestMapping(value = {"/case/okhttp"})
    public ModelAndView asyncCase() throws IOException {
        Request request = new Request.Builder()
            .url("http://localhost:18080/okhttp-case/rest/1")
            .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }

}
