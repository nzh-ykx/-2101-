package com.example.controller;

import com.example.entity.ComputerTableListBean;
import com.example.utils.CSVReaderUtil;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class ComputerController {
    private String computerData;

    private final ChatClient chatClient;


    public ComputerController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }


    @RequestMapping(value = "/getComputer")
    public ComputerTableListBean getComputer(@RequestParam(value="work") String work, @RequestParam(value="minPrice") String minPrice,
                                             @RequestParam(value="maxPrice") String maxPrice, @RequestParam(value="requirement") String requirement){
        String message = """
                按照下面的数据进行电脑配置推荐
                #数据
                {computerData}
                #要求
                职业:{work},
                电脑总体最低价格:{minPrice},
                电脑总体最高价格:{maxPrice},
                用户需求:{requirement},
                电脑最低价是指电脑所有配件相加下最低价，电脑最高价是指电脑所有配件相加的最高价，
                检索完所有数据后，从数据里配置出一台符号要求的电脑，把价格放在第一位严格执行，其次是需求，
                并只有返回结果,如果超过价格会受到惩罚;
                {format},totalPrice等于所有价格的相加，要在电脑总体最低价格和电脑总体最高价格
                结果是2个不同的方案
                """;
        try {
            computerData = CSVReaderUtil.readCsvAsString("C:\\Users\\Asus\\Desktop\\student\\springboot\\src\\main\\java\\com\\example\\utils\\computerdata.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BeanOutputConverter<ComputerTableListBean> bopc = new BeanOutputConverter<>(ComputerTableListBean.class);
        String format = bopc.getFormat();
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("computerData",computerData,"work",work,"minPrice",minPrice,
                "maxPrice",maxPrice,
                "requirement",requirement,"format",format));
        Prompt prompt = new Prompt(promptTemplate.createMessage());
        Generation generation = this.chatClient.prompt(prompt).call().chatResponse().getResult();
        ComputerTableListBean computerListBean = bopc.convert(generation.getOutput().getContent());
        return computerListBean;
    }
}
