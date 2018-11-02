/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srinivas
 */
public class Model implements Comparable {
     private int teach_id;
    private int rating;
    private int pending;

    public Model(int teach_id, int rating, int pending) {
        this.teach_id = teach_id;
        this.rating = rating;
        this.pending = pending;
    }
    
    

    public int getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(int teach_id) {
        this.teach_id = teach_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    
    @Override
    public int compareTo(Object o) {
        int compRating=((Model) o).getRating();
        return compRating-this.getRating();
    }
    
    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "[teach_id="+teach_id+",rating="+rating+",pending="+pending+"]";
    }
    
}
