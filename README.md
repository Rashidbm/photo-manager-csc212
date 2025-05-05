
# Photo Manager (CSC 212 – Data Structures Project)

## Overview

This project is a simple yet efficient photo management system that allows users to:
- Add and delete photos
- Assign multiple tags to each photo
- Create albums based on logical tag conditions (e.g., "cat AND park")
- Retrieve all matching photos for an album
- Track the number of tag comparisons made during a search

The system uses a **Binary Search Tree (BST)**-based inverted index to support efficient tag-based photo search, reducing the need to scan every photo linearly.

---

## Project Structure

### Photo
Represents a photo object.
- Stores the photo's unique path and associated tags
- Tags are stored in a custom linked list

### InvIndexPhotoManager
Manages all photos using an inverted index implemented as a BST:
- **Key**: Tag (String)
- **Value**: Linked list of Photo objects that contain the tag
- Core functionality:
  - `addPhoto(Photo p)`
  - `deletePhoto(String path)`
  - `getPhotos()` — returns the entire BST of tags and associated photos

### Album
Represents a filtered collection of photos based on a logical tag condition:
- Accepts conditions like "tag1 AND tag2"
- Returns matching photos via `getPhotos()`
- Tracks tag comparisons during search via `getNbComps()`

---

## Data Structures Used

- **Binary Search Tree (BST)**: Used as the inverted index for efficient tag lookup
- **Custom Linked List**: Used to store tags in `Photo` and to store lists of photos for each tag
- All data structures are implemented from scratch without using Java Collections

---

## How to Use

### Compile
javac src/*.java

### Run
java -cp src Test

---

## Notes

- Tags are **not** case-sensitive
- `getPhotos()` in `Album` performs an intersection of all tag lists matching the album’s condition
- If no condition is provided, all photos are returned
- Unused tags are removed from the index when a photo is deleted
- The project avoids using Java's built-in data structures to emphasize manual implementation of core algorithms

---

## Team Members

- Rashid Binkulaib  
- Ibrahim Altuwayjiri  
- Saud Almutairi
