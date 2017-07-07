package test.jedis;

import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * Created by ws on 2017-07-07.
 */
public class JedisTest {

    @Test
    public void test(){
        Jedis jedis = new Jedis();
        jedis.set("foo","bar");
        String value = jedis.get("foo");
        Assert.assertEquals(value,"bar");
    }

    @Test
    public void pool(){
        JedisPool pool = new JedisPool();
        Jedis jedis = pool.getResource();
        try {
            /// ... do stuff here ... for example
            jedis.set("foo", "bar1");
            String foobar = jedis.get("foo");

            jedis.zadd("sose", 2, "car"); jedis.zadd("sose", 1, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
            for(String s : sose){
                System.out.println(s);
            }

        } finally {
          if(jedis != null){
            jedis.close();
          }
        }

        pool.destroy();
    }
}
