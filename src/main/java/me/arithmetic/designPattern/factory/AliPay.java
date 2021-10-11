package me.arithmetic.designPattern.factory;

// 具体产品，支付宝支付
public class AliPay implements IPay {

    @Override
    public void pay() {
        System.out.println("ali pay");
    }

}
