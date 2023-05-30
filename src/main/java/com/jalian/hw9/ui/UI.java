package com.jalian.hw9.ui;
import com.jalian.hw9.dao.entities.Activity;
import com.jalian.hw9.dao.entities.ActivityState;
import com.jalian.hw9.dao.entities.User;
import com.jalian.hw9.service.Service;
import java.sql.Date;
import java.util.Scanner;
public class UI {
    private Scanner scanner = new Scanner(System.in);
    private Service service = new Service();
    public static void main(String[] args) {
        UI ui = new UI();
        //System.out.println(ui.service.getAllActivities());      woked correctly
        System.out.println("1)sign in\n2)log in");
        String option = ui.scanner.nextLine();
        if(option.equals("1")) {
            System.out.println("username:");
            String username = ui.scanner.nextLine();
            System.out.println("password:");
            String password = ui.scanner.nextLine();
            System.out.println("full name:");
            String fullName = ui.scanner.nextLine();
            User user = new User(username, password, fullName);
            try {
                ui.service.addUser(user);
                System.out.println("done!!!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if(option.equals("2")) {
            System.out.println("username:");
            String username = ui.scanner.nextLine();
            System.out.println("password:");
            String password = ui.scanner.nextLine();
            User user = new User(username, password);
            try {
                user = ui.service.authentication(user);
                if (user == null) {
                    System.out.println("bad input!!");
                } else {
                    ui.menu(ui, user);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("bad input!!!!");
        }
        ui.close();
    }
    private void close() {
        service.close();
    }
    private void menu(UI ui, User user) {
        System.out.println("1)add an activity\n2)see all activities\n3)update an activity");
        String option = ui.scanner.nextLine();
        if(option.equals("1")) {
            System.out.println("description:");
            String description = ui.scanner.nextLine();
            System.out.println("state:\n1)open\n2)copleted\n3)in progress");
            ActivityState activityState;
            String activityStateOption = ui.scanner.nextLine();
            if(activityStateOption.equals("1")) {
                activityState = ActivityState.open;
            } else if(activityStateOption.equals("2")) {
                activityState = ActivityState.copleted;
            } else if(activityStateOption.equals("3")) {
                activityState = ActivityState.inProgress;
            } else {
                System.out.println("bad input!!!");
                return;
            }
            //Date date = new Date(System.currentTimeMillis());
            Activity activity = new Activity(description, activityState);
            activity.setUser(user);
            //activity.setCreateDate(date);
            ui.service.addActivity(activity);
        } else if(option.equals("2")) {
            for(Activity activity : ui.service.getAllUserActivities(user.getUsername())) {
                System.out.println(activity.toString());
            }
        } else if(option.equals("3")) {
            System.out.println("insert your activity id:");
            int id = Integer.parseInt(ui.scanner.nextLine());
            Activity activity = ui.service.getActivity(id);
            if(activity == null) {
                System.out.println("bad input!!!");
            } else {
                System.out.println(activity.toString());
                System.out.println("your new description:");
                String description = ui.scanner.nextLine();
                System.out.println("your new state:");
                ActivityState activityState;
                String activityStateOption = ui.scanner.nextLine();
                if(activityStateOption.equals("1")) {
                    activityState = ActivityState.open;
                } else if(activityStateOption.equals("2")) {
                    activityState = ActivityState.copleted;
                } else if(activityStateOption.equals("3")) {
                    activityState = ActivityState.inProgress;
                } else {
                    System.out.println("bad input!!!");
                    return;
                }
                activity.setActivityState(activityState);
                activity.setName(description);
                activity = ui.service.updateActivity(activity);
                System.out.println(activity.toString());
            }
        } else {
            System.out.println("bad input!!!!");
        }
    }
}