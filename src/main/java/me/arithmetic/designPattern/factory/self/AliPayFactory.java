package me.arithmetic.designPattern.factory.self;

import me.arithmetic.designPattern.factory.AliPay;
import me.arithmetic.designPattern.factory.IPay;

public class AliPayFactory implements IPayFactory {
    @Override
    public IPay getIPay() {
        return new AliPay();
    }
}
