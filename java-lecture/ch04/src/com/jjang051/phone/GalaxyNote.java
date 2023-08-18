package com.jjang051.phone;

public class GalaxyNote implements MobilePhoneInterface, Mp3Interface {

    @Override
    public void sendCall() {
        System.out.println("노트가 전화를 겁니다.");
    }

    @Override
    public void receiveCall() {
        System.out.println("노트가 전화를 받습니다.");
    }

    @Override
    public void sendSms() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendSms'");
    }

    @Override
    public void receiveSms() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveSms'");
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

}
