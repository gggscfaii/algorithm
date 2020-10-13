package com.wsd.algorithm.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.framework.state.ConnectionState;

/**
 * LeaderSelectorListenerTest
 *
 * @author wangshudong
 * @date 2020/10/12
 */
public class LeaderSelectorListenerTest {


    public static void main(String[] args) {

        LeaderSelector selector = new LeaderSelector(null, "/test/master", new LeaderSelectorListener() {
            @Override
            public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {

            }

            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
            }
        });
    }
}
