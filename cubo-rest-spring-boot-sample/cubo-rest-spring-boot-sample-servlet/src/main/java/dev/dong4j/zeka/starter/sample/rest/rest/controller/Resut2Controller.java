package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import dev.dong4j.zeka.kernel.common.api.R;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.base.BasePage;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.TestEntity;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class Resut2Controller extends ServletController {

    /**
     * String result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_string2")
    @ResponseBody
    public String stringResult() {
        return "hello";
    }

    /**
     * String array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_string_array2")
    public String[] stringArrayResult() {
        return new String[]{"hello", "world"};
    }

    /**
     * Boolean result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_boolean2")
    public Boolean booleanResult() {
        return true;
    }

    /**
     * Boolean array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_boolean_array2")
    public Boolean[] booleanArrayResult() {
        return new Boolean[]{true, false};
    }

    /**
     * Integer result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_integet2")
    public Integer integerResult() {
        return 1024;
    }

    /**
     * Integer array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_integer_array2")
    public Integer[] integerArrayResult() {
        return new Integer[]{1024, 2048};
    }

    /**
     * Long result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_long2")
    public Long longResult() {
        return 1024L;
    }

    /**
     * Logng array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_long_array2")
    public Long[] logngArrayResult() {
        return new Long[]{1024L, 2048L};
    }

    /**
     * Byte result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_byte2")
    public Byte byteResult() {
        return new Byte("111");
    }

    /**
     * Byte array result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_byte_array2")
    public Byte[] byteArrayResult() {
        return new Byte[]{new Byte("111")};
    }

    /**
     * List result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_list_12")
    public List<String> listResult() {
        return new ArrayList<String>(2) {
            private static final long serialVersionUID = -4614637282868378637L;

            {
                this.add("xxx");
                this.add("yyy");
            }
        };
    }

    /**
     * List user result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_list_22")
    public List<User> listUserResult() {
        return new ArrayList<User>(2) {
            private static final long serialVersionUID = 639119349909050251L;

            {
                this.add(User.builder().name("xxx").build());
                this.add(User.builder().name("yyy").build());
            }
        };
    }

    /**
     * Map result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_map_12")
    public Map<String, String> mapResult() {
        return new HashMap<String, String>(2) {
            private static final long serialVersionUID = 2481746330970621030L;

            {
                this.put("xxx", "aaa");
                this.put("yyy", "bbb");
            }
        };
    }

    /**
     * User map result result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_map_22")
    public Map<String, User> userMapResult() {
        return new HashMap<String, User>(2) {
            private static final long serialVersionUID = -5385708893405727014L;

            {
                this.put("xxx", User.builder().name("xxx").build());
                this.put("yyy", User.builder().name("yyy").build());
            }
        };
    }

    /**
     * Sets result *
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/result_set_12")
    public Set<String> setResult() {
        return new HashSet<String>(2) {
            private static final long serialVersionUID = -3610574753364312342L;

            {
                this.add("xxx");
                this.add("yyy");
            }
        };
    }

    /**
     * Sets user result *
     *
     * @return the user result
     * @since 1.0.0
     */
    @GetMapping("/result_set_22")
    public Set<User> setUserResult() {
        return new HashSet<User>(2) {
            private static final long serialVersionUID = 6068087030306279221L;

            {
                this.add(User.builder().name("xxx").build());
                this.add(User.builder().name("yyy").build());
            }
        };
    }

    /**
     * Page 1
     *
     * @return the base page
     * @since 1.7.0
     */
    @GetMapping("/result_page")
    public BasePage<?> page1() {
        return new BasePage<TestEntity>() {
            @Override
            public IPage<TestEntity> getPagination() {
                return initPageObject();
            }

            @Override
            public BasePage<TestEntity> setPagination(IPage<TestEntity> pagination) {
                return super.setPagination(pagination);
            }
        };
    }


    /**
     * Page 2
     *
     * @return the page
     * @since 1.7.0
     */
    @GetMapping("/result_page_1")
    public IPage<TestEntity> page2() {
        return initPageObject();
    }

    /**
     * Page 2
     *
     * @return the page
     * @since 1.7.0
     */
    @GetMapping("/result_page_2")
    public Result<IPage<TestEntity>> page3() {
        IPage<TestEntity> iPage = initPageObject();
        return R.succeed(iPage);
    }

    /**
     * Init page object
     *
     * @return the page
     * @since 1.7.0
     */
    private IPage<TestEntity> initPageObject() {
        return new IPage<TestEntity>() {
            @Override
            public List<OrderItem> orders() {
                return null;
            }

            @Override
            public List<TestEntity> getRecords() {
                return null;
            }

            @Override
            public IPage<TestEntity> setRecords(List<TestEntity> records) {
                return null;
            }

            @Override
            public long getTotal() {
                return 0;
            }

            @Override
            public IPage<TestEntity> setTotal(long total) {
                return null;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public IPage<TestEntity> setSize(long size) {
                return null;
            }

            @Override
            public long getCurrent() {
                return 0;
            }

            @Override
            public IPage<TestEntity> setCurrent(long current) {
                return null;
            }
        };
    }
}
