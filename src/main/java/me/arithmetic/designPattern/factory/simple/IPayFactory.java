package me.arithmetic.designPattern.factory.simple;

import me.arithmetic.designPattern.factory.AliPay;
import me.arithmetic.designPattern.factory.IPay;
import me.arithmetic.designPattern.factory.WechatPay;

// 简单工厂
// 工厂类
public class IPayFactory {

    /**
     * 根据参数 返回对应的支付对象
     */
    public static IPay createPay(String payType) {
        switch (payType) {
            case "alipay":
                return new AliPay();
            case "wechat":
                return new WechatPay();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        IPay iPay = createPay("alipay");
        iPay.pay();
    }
}
