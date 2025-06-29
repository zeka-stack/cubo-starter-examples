package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: MatrixVariable 注解测试 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 16:42
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/matrix_variable")
public class MatrixVariableController {

    /**
     * 请求  /test2/1s;a=1,2,3;b=a;c=cc/p/sjy;s=2;j=3;y=3;d=a,b,c,d
     * 输出响应  {a=[1, 2, 3], b=[a], c=[cc]}-----{s=[2], j=[3], y=[3], d=[a, b, c, d]}
     * 如果将@MatrixVariable注解中的pathVar属性去掉
     * 相同的请求
     * 输出响应  {a=[1, 2, 3], b=[a], c=[cc], s=[2], j=[3], y=[3], d=[a, b, c, d]}-----{a=[1, 2, 3], b=[a], c=[cc], s=[2], j=[3], y=[3],
     * d=[a, b, c, d]}
     *
     * @param id   id
     * @param name name
     * @return the object
     * @since 1.0.0
     */
    @RequestMapping(value = "test2/{id}/p/{name}")
    public Object test2(@MatrixVariable(pathVar = "id") Map<String, String[]> id,
                        @MatrixVariable(pathVar = "name") Map<String, String[]> name) {
        return id + "-----" + name;
    }

    /**
     * /test3/1;q=1,2,3;b=a;c=cc/test3/12;s=2;j=3;y=3;d=a,b,c,d
     * ownerId: 1----petId: 12----q: 1,2,3----matrixVars: {q=[1, 2, 3], b=[a], c=[cc]}---petMatrixVars: {s=[2], j=[3], y=[3], d=[a, b, c,
     * d]}
     *
     * @param ownerId       owner id
     * @param petId         pet id
     * @param q             q
     * @param matrixVars    matrix vars
     * @param petMatrixVars pet matrix vars
     * @return the object
     * @since 1.0.0
     */
    @RequestMapping(value = "/test3/{ownerId}/test3/{petId}", method = RequestMethod.GET)
    public Object findPet(
        @PathVariable(value = "ownerId") Integer ownerId,
        @PathVariable(value = "petId") Integer petId,
        @MatrixVariable(pathVar = "ownerId", value = "q") String q,
        @MatrixVariable(pathVar = "ownerId") Map<String, String> matrixVars,
        @MatrixVariable(pathVar = "petId") Map<String, String> petMatrixVars) {
        return "ownerId: " + ownerId + "----petId: " + petId + "----q: " + q +
            "----matrixVars: " + matrixVars + "---petMatrixVars: " + petMatrixVars;
    }

}
