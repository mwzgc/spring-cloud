package com.mwz.netty.server;

import com.alibaba.fastjson.JSON;
import com.mwz.proto.PersonObject;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

import java.io.ByteArrayOutputStream;

/**
 * @author mwz
 */
public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        PersonObject.Person john = PersonObject.Person.newBuilder()
                .setId(1234)
                .setName("John Doe")
                .setEmail("jdoe@example.com")
                .build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        john.writeTo(output);

        byte[] bytes = output.toByteArray();
        System.out.println(bytes.length);
        System.out.println(john);

        String jsonString = JSON.toJSONString(new P().setId(1234).setName("John Doe").setEmail("jdoe@example.com"));
        System.out.println(jsonString);
        System.out.println(jsonString.getBytes().length);
    }

}

@Data
@Accessors(chain = true)
class P {
    private Integer id;
    private String name;
    private String email;
}
