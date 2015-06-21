package com.rixon.projecteuler.main;

import com.rixon.projecteuler.utils.Employee;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rixonmathew on 14/06/15.
 */
public class MultiThreadedMapTest {

    @Test
    public void testAccessAndMutationWithHashMap() {
        final HashMap<Integer,Employee> employees = populateMapWith(5000);
        final Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++) {
            executorService.submit(new Runnable() {

                @Override
                public void run() {
                    for (Map.Entry<Integer,Employee> entry:employees.entrySet()) {
                        int id = entry.getKey();
                        if (id % 50 == 0) {
                            System.out.println("Removing "+id+" from thread id "+Thread.currentThread().getId());
                            employees.remove(id);
                        }

                    }

                    for (int i = 0; i < employees.size(); i++) {
                        int id = random.nextInt(employees.size());
                        employees.get(id).setFirstName("Modified name");
                        //System.out.println("Modifying " + i + "from thread id " + Thread.currentThread().getId());
                        if (i % 50 == 0) {
                            System.out.println("Removing "+i+"from thread id "+Thread.currentThread().getId());
                            employees.remove(i);
                        }
                    }
                }
            });
        }

        executorService.shutdown();
        System.out.println("Waiting..");
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done..");

    }

    private HashMap<Integer, Employee> populateMapWith(int maxElement) {
        HashMap<Integer,Employee> employees = new HashMap<>();
        for (int i=0;i<maxElement;i++){
            Employee employee = new Employee();
            employee.setId(i);
            employee.setFirstName("User"+i);
            employee.setLastName("LastUser"+i);
            employees.put(i,employee);
        }
        return employees;
    }
}
