package me.arasple.mc.trchat.bstats;

import io.izzel.taboolib.module.inject.TSchedule;
import me.arasple.mc.trchat.TrChat;

import java.text.DecimalFormat;

/**
 * @author Arasple
 */
public class Metrics {

    private static MetricsBukkit metrics;
    private static DecimalFormat doubleFormat = new DecimalFormat("#.#");
    private static int[] coutns = new int[]{0, 0};

    public static void increase(int index) {
        increase(index, 1);
    }

    public static void increase(int index, int value) {
        if (coutns[index] < Integer.MAX_VALUE) {
            coutns[index] += value;
        }
    }

    @TSchedule
    public static void init() {
        metrics = new MetricsBukkit(TrChat.getPlugin());

        // 聊天次数统计
        metrics.addCustomChart(new MetricsBukkit.SingleLineChart("chat_counts", () -> {
            int i = coutns[0];
            coutns[0] = 0;
            return i;
        }));
        // 敏感词过滤器启用统计
        metrics.addCustomChart(new MetricsBukkit.SingleLineChart("filter_counts", () -> {
            int i = coutns[1];
            coutns[1] = 0;
            return i;
        }));
    }

    public static MetricsBukkit getMetrics() {
        return metrics;
    }


}