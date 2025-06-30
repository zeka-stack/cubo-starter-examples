package dev.dong4j.zeka.starter.sample.mybatis.tenant.table.strategy;

import java.util.Collection;
import java.util.Random;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Description: 自定义分表策略 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.23 08:39
 * @since 1.0.0
 */
public class OrderShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    /**
     * Do sharding string
     *
     * @param availableTargetNames available target names
     * @param shardingValue        sharding value
     * @return the string
     * @since 1.0.0
     */
    @Override
    @SuppressWarnings("PMD.UndefineMagicConstantRule")
    public String doSharding(@NotNull Collection<String> availableTargetNames, @NotNull PreciseShardingValue<String> shardingValue) {
        // 从 context 获取 tenant_id
        String tenantId = "2";
        int random = new Random().nextInt(10);
        if (random % 2 == 1) {
            tenantId = "1";
        }

        String targetTable = "t_order_" + tenantId;
        if (availableTargetNames.contains(targetTable)) {
            return targetTable;
        }

        throw new UnsupportedOperationException("无法判定的值: " + shardingValue.getValue());
    }
}
