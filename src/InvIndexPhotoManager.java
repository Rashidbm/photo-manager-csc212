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
        if(invertedIndex.empty())
        return;
        
        //Search for Path tags, if its not found it will return null, and the " PathTagss==null " will catch it.
        LinkedList<String> PathTags=FindPathTags(invertedIndex.root,path);



        
        if(PathTags==null)
        return;

        //Delete part
        PathTags.findFirst();
        while(true){
            if(invertedIndex.findkey(PathTags.retrieve())) {

                LinkedList<Photo> PhotoList = invertedIndex.retrieve();
                
                /* if the photo list is empty skip it and check if it is the last element exit the tags loop 
                if its not go to the next tag and continue the loop */ 
                if(PhotoList.empty()) {
                    if(PathTags.last())
                        break;

                    PathTags.findNext();
                    continue;
                }
                
                boolean Removed = false;
                PhotoList.findFirst();
                while(!PhotoList.last()){
                    if(PhotoList.retrieve().getPath().equals(path)){
                        PhotoList.remove();
                        Removed=true;
                        break;
                    }
                    PhotoList.findNext();
            }
            if(!Removed){
            if(PhotoList.retrieve().getPath().equals(path))
                PhotoList.remove();
        }
            //checks if the data in the key is empty
            if(invertedIndex.retrieve().empty())
                invertedIndex.remove_key(PathTags.retrieve());
        }
        if(PathTags.last())
        break;

        PathTags.findNext();
        
    }
}//End of delete

//Find path tags
private LinkedList<String> FindPathTags(BSTNode<LinkedList<Photo>> b, String path){
   if(b==null)
   return null;

   LinkedList<Photo> listPhoto = b.data;
   listPhoto.findFirst();
   while(!listPhoto.last()){
        if(listPhoto.retrieve().getPath().equals(path))
            return listPhoto.retrieve().getTags();
        listPhoto.findNext();
   }
   if(listPhoto.retrieve().getPath().equals(path))
        return listPhoto.retrieve().getTags();
    
    LinkedList<String> left = FindPathTags(b.left,path);
    if(left !=null)
        return left;
        
    LinkedList<String> right = FindPathTags(b.right,path);
    if(right !=null)
        return right;
    
    return null;


   }
 

    // Return the inverted index of all managed photos
    public BST<LinkedList<Photo>> getPhotos() {
        return invertedIndex;
    }
}
