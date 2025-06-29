package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.dong4j.zeka.kernel.common.api.BaseCodes;
import dev.dong4j.zeka.kernel.common.api.IResultCode;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.enums.ServletCodeEnum;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: 统一响应结果 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 20:32
 * @since 1.0.0
 */
@RestController
@SuppressWarnings("all")
public class ResutController extends ServletController {

    /**
     * Void result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_void_1")
    public Result<Void> voidResult_1() {
        return this.ok();
    }

    /**
     * Void result 2
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_void_2")
    public Result<Void> voidResult_2() {
        return this.ok(null);
    }

    /**
     * String result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_string")
    public Result<String> stringResult() {
        return this.ok("hello");
    }

    /**
     * String array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_string_array")
    public Result<String[]> stringArrayResult() {
        return this.ok(new String[]{"hello", "world"});
    }

    /**
     * Boolean result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_boolean")
    public Result<Boolean> booleanResult() {
        return this.ok(true);
    }

    /**
     * Status result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_status")
    public Result<Boolean> statusResult() {
        return this.status(true);
    }

    /**
     * Boolean array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_boolean_array")
    public Result<Boolean[]> booleanArrayResult() {
        return this.ok(new Boolean[]{true, false});
    }

    /**
     * Integer result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_integet")
    public Result<Integer> integerResult() {
        return this.ok(1024);
    }

    /**
     * Integer array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_integer_array")
    public Result<Integer[]> integerArrayResult() {
        return this.ok(new Integer[]{1024, 2048});
    }

    /**
     * Long result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_long")
    public Result<Long> longResult() {
        return this.ok(1024L);
    }

    /**
     * Logng array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_long_array")
    public Result<Long[]> logngArrayResult() {
        return this.ok(new Long[]{1024L, 2048L});
    }

    /**
     * Byte result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_byte")
    public Result<Byte> byteResult() {
        return this.ok(new Byte("111"));
    }

    /**
     * Byte array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_byte_array")
    public Result<Byte[]> byteArrayResult() {
        return this.ok(new Byte[]{new Byte("111"), new Byte("222")});
    }

    /**
     * Date result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_date")
    public Result<Date> dateResult() {
        return this.ok(new Date());
    }

    /**
     * Json node result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_json_1")
    public Result<JsonNode> jsonNodeResult() {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("username", "dong4j");
        return this.ok(objectNode);
    }

    /**
     * Object node result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_json_2")
    public Result<ObjectNode> objectNodeResult() {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("username", "dong4j");
        return this.ok(objectNode);
    }

    /**
     * User result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_object")
    public Result<User> userResult() {
        return this.ok(User.builder().name("dong4j").build());
    }

    /**
     * List result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_list_1")
    public Result<List<String>> listResult() {
        return this.ok(new ArrayList<String>(2) {
            private static final long serialVersionUID = -4614637282868378637L;

            {
                this.add("xxx");
                this.add("yyy");
            }
        });
    }

    /**
     * List user result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_list_2")
    public Result<List<User>> listUserResult() {
        return this.ok(new ArrayList<User>(2) {
            private static final long serialVersionUID = 639119349909050251L;

            {
                this.add(User.builder().name("xxx").build());
                this.add(User.builder().name("yyy").build());
            }
        });
    }

    /**
     * Map result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_map_1")
    public Result<Map<String, String>> mapResult() {
        return this.ok(new HashMap<String, String>(2) {
            private static final long serialVersionUID = 2481746330970621030L;

            {
                this.put("xxx", "aaa");
                this.put("yyy", "bbb");
            }
        });
    }

    /**
     * User map result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_map_2")
    public Result<Map<String, User>> userMapResult() {
        return this.ok(new HashMap<String, User>(2) {
            private static final long serialVersionUID = -5385708893405727014L;

            {
                this.put("xxx", User.builder().name("xxx").build());
                this.put("yyy", User.builder().name("yyy").build());
            }
        });
    }

    /**
     * Sets result *
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_set_1")
    public Result<Set<String>> setResult() {
        return this.ok(new HashSet<String>(2) {
            private static final long serialVersionUID = -3610574753364312342L;

            {
                this.add("xxx");
                this.add("yyy");
            }
        });
    }

    /**
     * Sets user result *
     *
     * @return the user result
     * @since 1.0.0
     */
    @GetMapping("/result_set_2")
    public Result<Set<User>> setUserResult() {
        return this.ok(new HashSet<User>(2) {
            private static final long serialVersionUID = 6068087030306279221L;

            {
                this.add(User.builder().name("xxx").build());
                this.add(User.builder().name("yyy").build());
            }
        });
    }

    /**
     * Error result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/error_1")
    public Result errorResult() {
        return this.fail("xx");
    }

    /**
     * Code result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/error_2")
    public Result codeResult() {
        return this.fail(new IResultCode() {
            private static final long serialVersionUID = 1415708895867619184L;

            @Override
            public String getMessage() {
                return "xxx";
            }

            @Override
            public Integer getCode() {
                return 0;
            }

        });
    }

    /**
     * Code result 1
     *
     * @return the result
     * @since 1.5.0
     */
    @GetMapping("/error_BaseCodes_test")
    public Result codeResult1() {
        return this.fail(BaseCodes.PARAM_VERIFY_ERROR);
    }

    /**
     * Code result 2
     *
     * @return the result
     * @since 1.5.0
     */
    @GetMapping("/error_ServletCodeEnum_test")
    public Result codeResult2() {
        return this.fail(ServletCodeEnum.METHOD_ARGUMENT_NOT_VALID);
    }

    /**
     * Code result 2
     *
     * @return the result
     * @since 1.5.0
     */
    @GetMapping("/error_OtherCodeEnum_test")
    public Result codeResult3() {
        return this.fail(new IResultCode() {
            @Override
            public String getMessage() {
                return null;
            }

            @Override
            public Integer getCode() {
                return 0;
            }

        });
    }

    /**
     * 基础类型序列化
     *
     * @return the result
     * @since 1.6.0
     */
    @GetMapping("/json")
    public Result<NumberVO> json() {
        return this.ok(NumberVO.builder().id(1L).ageBase(2).build());
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.0.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.09.23 10:58
     * @since 1.6.0
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NumberVO {
        /** 包装类型为 null 时不序列化 */
        private Long id;
        /** 基础类型无值时默认为基础类型的默认值 */
        private long idBase;
        /** Age */
        private Integer age;
        /** Age base */
        private int ageBase;
        /** Dd */
        private Double dd;
        /** Ddd */
        private double ddd;
        /** Bb */
        private BigDecimal bb;
        /** List */
        private List<String> list;
        /** Map */
        private Map<String, Object> map;
        /** Date */
        private Date date;
        /** Value */
        private String value;
    }

}
