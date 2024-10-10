# DBSCAN Implementation

This is a Java implementation of the famous clustering algorithm DBSCAN.

## Algorithm

**DBSCAN** (Density-Based Spatial Clustering of Applications with Noise) is a clustering algorithm that groups points based on their density. It identifies clusters as dense regions separated by sparser areas. Key parameters include:

- **Epsilon (ε)**: The radius around a point to search for neighboring points.
- **MinPts**: The minimum number of points required to form a dense region (cluster).
  
Points are classified as:

- **Core points**: Have at least MinPts within ε.
- **Border points**: Are within ε of a core point but do not meet MinPts.
- **Noise points**: Are neither core nor border points.

## Results

As per image below, after running the algorithm with the csv dataset in this repository two cluster have been identified:
  
![qgisMap](https://github.com/user-attachments/assets/cdbb62a9-1bb9-4412-9f26-5a0d49ae0a8d)
