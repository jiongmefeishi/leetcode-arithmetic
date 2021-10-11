package me.arithmetic.designPattern.factory;

// 具体产品，微信支付
public class WechatPay implements IPay {

    @Override
    public void pay() {
        System.out.println("wechat pay");
    }

}
