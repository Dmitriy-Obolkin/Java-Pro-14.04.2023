package src.main.homeworks.hw5.hw5_1to9;

public abstract class Member implements Rest{

    /*Поле maxRunDistance - это максимально возможное расстояние,
    * на которое может пробежать учасник без отдыха, с ним связанно поле stamina,
    * оно будет тратится динамически по мере того, сколько
    * препятствий "Беговая дорожка" прошёл учасник за один подход,
    * и восстанавливаться после отдыха*/
    protected final int maxRunDistance;
    private int stamina;
    /*maxJumpHeight - это просто максимальная высота, на которую
    * может прыгнуть учасник*/
    protected final int maxJumpHeight;

    public final String name;

    public Member(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.setStamina(getMaxRunDistance());
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }
    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }
    public String getName() {
        return name;
    }
    public int getStamina() {
        return stamina;
    }
    /*Закрыть доступ к случайному изменению поля stamina*/
    private void setStamina(int stamina) {
        if(stamina <= 0){
            throw new IllegalArgumentException("The stamina must be a positive number!");
        }
        this.stamina = stamina;
    }


    public boolean run(int distance){
        if(distance <= 0){
            throw new IllegalArgumentException("The distance must be a positive number!");
        }

        if(distance <= getStamina()){
            System.out.println(this + " runs for a distance of: " + distance + " meters!");
            stamina -= distance;
            return true;
        }
        else {
            System.out.println(this + " cannot run a distance of: " + distance + " meters!");
            return false;
        }
    }
    /*Прыжок зависит только от максимальной высоты, на которую может прыгнуть учасник*/
    public boolean jump(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("The height must be a positive number!");
        }

        if (height <= getMaxJumpHeight()) {
            System.out.println(this + " jumps to a height of: " + height + " meters!");
            return true;
        } else {
            System.out.println(this + " cannot jumps to a height of: " + height + " meters!");
            return false;
        }
    }


    @Override
    public boolean rest(){
        if(getStamina() < getMaxRunDistance()){
            this.setStamina(getMaxRunDistance());
            return true;
        }
        else {
            return false;
        }
    }

}
