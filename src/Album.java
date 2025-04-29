public class Album {
    private String name;
    private String condition;
    private PhotoManager manager;

    public Album(String name, String condition, PhotoManager manager) {
        this.name = name;
        this.condition = condition;
        this.manager = manager;
    }

    // name getter
    public String getName() {
        return name;
    }

    // condition getter
    public String getCondition() {
        return condition;
    }

    // manager getter
    public PhotoManager getManager() {
        return manager;
    }

    // Return all photos that meet the conditions 
    public LinkedList<Photo> getPhotos() {
        // To be implemented
        return new LinkedList<Photo>();
    }

    // Return the number of tag comparisons used to find all photos of the album (hint: get advantage of getPhotos)
    public int getNbComps() {
        // To be implemented
        return 0;
    }
}
