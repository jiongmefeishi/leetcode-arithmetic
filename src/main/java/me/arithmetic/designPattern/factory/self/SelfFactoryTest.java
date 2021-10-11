package me.arithmetic.designPattern.factory.self;

import me.arithmetic.designPattern.factory.IPay;

public class SelfFactoryTest {

    public static void main(String[] args) {
        IPay iPay = new WechatPayFactory().getIPay();
        iPay.pay();
    }
}
