package me.arithmetic.designPattern.factory.self;

import me.arithmetic.designPattern.factory.IPay;
import me.arithmetic.designPattern.factory.WechatPay;

public class WechatPayFactory implements IPayFactory {

    @Override
    public IPay getIPay() {
        return new WechatPay();
    }
}
