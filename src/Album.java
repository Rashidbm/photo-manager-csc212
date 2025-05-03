public class Album {
    private String name;
    private String condition;
    private PhotoManager manager;
    private int nbComps; 

    public Album(String name, String condition, PhotoManager manager) {
        this.name = name;
        this.condition = condition;
        this.manager = manager;
        this.nbComps = 0;
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

    public LinkedList<Photo> getPhotos() {
        nbComps = 0; 

        LinkedList<Photo> result = new LinkedList<>();

        if (condition == null || condition.isEmpty()) 
            return manager.getPhotos();

        String[] tags = condition.split(" AND ");

        manager.getPhotos().findFirst();
        do {
            Photo p = manager.getPhotos().retrieve();
            boolean match = true;

            for (String tag : tags) {
                boolean found = false;
                p.getTags().findFirst();

                do {
                    nbComps++;
                    if (p.getTags().retrieve().equals(tag)) {
                        found = true;
                        break;
                    }
                    p.getTags().findNext();
                } while (!p.getTags().last());

                if (!found) {
                    match = false;
                    break;
                }
            }

            if (match)
                result.insert(p);

            manager.getPhotos().findNext();
        } while (!manager.getPhotos().last());

        return result;
    }

    
    public int getNbComps() {
        return nbComps;
    }
}
