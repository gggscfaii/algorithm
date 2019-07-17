package com.wsd.algorithm.hash;

import com.google.common.collect.Lists;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * KetamaHashStrategy
 * Created by sdwang on 2019/3/14 9:32.
 */
public class KetamaHashStrategy {
    public static final MessageDigestPool digestPool = new MessageDigestPool(100);

    public static void main(String[] args) {

        List<Integer> groupIds = Lists.newArrayList(1, 2, 3);
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        for (int groupId : groupIds) {
            for (int i = 0; i < 1000; i++) {
                byte[] digest = getHash((groupId + "_" + i).getBytes());
                Long m = getLong(digest);
                map.put(m, groupId);
            }
        }

        System.out.println(map);

        double number = 12.12;

        System.out.println(number);                         //12.0

        System.out.println(Double.toString(number));        //12.0

        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        System.out.println(decimalFormat.format(number));   //12

    }

    private static Long getLong(byte[] digest) {

        ByteBuffer _intShifter = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE)
                .order(ByteOrder.LITTLE_ENDIAN);
        _intShifter.clear();
        _intShifter.put(digest, 0, Integer.SIZE / Byte.SIZE);
        _intShifter.flip();
        int temp = _intShifter.getInt();

        return temp & 0xffffffffl;
    }

    private static byte[] getHash(byte[] key){
        return digestPool.ComputHash(key);
    }

    public static class MessageDigestPool {

        private BlockingDeque<MessageDigest> queue;

        public MessageDigestPool(int poolSize) {
            queue = new LinkedBlockingDeque<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                try {
                    queue.add(MessageDigest.getInstance("MD5"));
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public byte[] ComputHash(byte[] key) {
            MessageDigest digest = null;
            try {
                digest = queue.take();
                return digest.digest(key);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if (digest != null)
                    try {
                        queue.put(digest);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        }

    }
}
