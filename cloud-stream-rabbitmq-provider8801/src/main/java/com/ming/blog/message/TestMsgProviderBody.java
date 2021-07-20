package com.ming.blog.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

/**
 * @author MrJiangZM
 * @since <pre>2021/7/20</pre>
 */
@Data
@AllArgsConstructor
public class TestMsgProviderBody implements Serializable {

    private Long id;
    private String name;
    private String serialNumber;

}
