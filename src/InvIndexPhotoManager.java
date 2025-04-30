public class InvIndexPhotoManager {
    private BST<LinkedList<Photo>> invertedIndex;

    // Constructor
    public InvIndexPhotoManager() {
        invertedIndex = new BST<LinkedList<Photo>>();
    }

    // Add a photo
    public void addPhoto(Photo p) {
        LinkedList<String> photo_tags = p.getTags();
        if(photo_tags.empty())
            return;
        
        // we iterate over all the tags
        photo_tags.findFirst();
        while(!photo_tags.last()){
            if(invertedIndex.findkey(photo_tags.retrieve())){
                invertedIndex.retrieve().insert(p);
            }
            else{
                // tag not found. Insert new tag node with photo list
                LinkedList<Photo> ll = new LinkedList<Photo>();
                ll.insert(p);
                invertedIndex.insert(photo_tags.retrieve(), ll);
            }
            // move to next tag
            photo_tags.findNext();
        }
        // handle the last tag.
        if(invertedIndex.findkey(photo_tags.retrieve())){
            invertedIndex.retrieve().insert(p);
        }
        else{
            LinkedList<Photo> ll = new LinkedList<Photo>();
            ll.insert(p);
            invertedIndex.insert(photo_tags.retrieve(), ll);
        }
    }

    // Delete a photo
    public void deletePhoto(String path) {
        // To be implemented
    }

    // Return the inverted index of all managed photos
    public BST<LinkedList<Photo>> getPhotos() {
        // To be implemented
        return null;
    }
}
