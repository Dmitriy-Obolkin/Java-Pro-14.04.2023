package homeworks.hw11.hw11_1;

public class ThreadSafeListDemo {
    public static void main(String[] args) throws InterruptedException{
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();

        Thread threadAdd = new Thread(() -> {
           for(int i = 0; i < 10; i++){
               threadSafeList.add(i);
               System.out.println("Added: " + i);
               try{
                    Thread.sleep(150);
               } catch (InterruptedException e){
                   System.out.println("Thread threadAdd is interrupted.");
               }
           }
        });

        Thread threadRemove = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try{
                    threadSafeList.remove(i);
                    System.out.println("Removed: " + i);
                } catch (IllegalArgumentException e){
                    System.out.println("Failed to remove: " + i);
                }

                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){
                    System.out.println("Thread threadRemove is interrupted.");
                }
            }
        });


        threadAdd.start();
        threadRemove.start();

        threadAdd.join();
        threadRemove.join();

        for (int i = 0; i < 10; i++) {
            try{
                Integer value = threadSafeList.get(i);
                System.out.println("Remaining: " + value);
            } catch (IndexOutOfBoundsException e){
                System.out.println("No more elements in the list.");
                break;
            }
        }

    }
}
