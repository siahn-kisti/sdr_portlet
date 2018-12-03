import io, sys, base64
import numpy as np
import sklearn
import kmapper as km

# Devsky sorted by electronegativity
def SortByAtomicNumber(atom):
    for lable in phase.elements :
        if lable.name == atom:
            return lable.X

# Input : JSON file path
#
# Output 1 : Phase diagram pdf file
# Output 2 : Compounds list JSON file

file_path = str(sys.argv[1])
output_Path = str(sys.argv[2])

try:
    from scipy.misc import imsave, toimage
except ImportError as e:
    print("imsave requires you to install pillow. Run `pip install pillow` and then try again.")
    sys.exit()

data = np.genfromtxt(file_path, delimiter=',')

# Create images for a custom tooltip array
tooltip_s = []
for image_data in data:
    output = io.BytesIO()
    img = toimage(image_data.reshape((1, 3)))  # Data was a flat row of 64 "pixels".
    img.save(output, format="PNG")
    contents = output.getvalue()
    img_encoded = base64.b64encode(contents)
    img_tag = """<img src="data:image/png;base64,{}">""".format(img_encoded.decode('utf-8'))
    tooltip_s.append(img_tag)
    output.close()

tooltip_s = np.array(tooltip_s)  # need to make sure to feed it as a NumPy array, not a list

mapper = km.KeplerMapper(verbose=0)

# X_inverse : Original data
# projection : ["sum", "mean", "median", "max", "min", "std", "dist_mean", "l2norm", "knn_distance_n"]
# scaler : Scaler/transformer to be applied after the projection. Use None to do no scaling.
# distance_matrix : ["braycurtis", "canberra", "chebyshev", "cityblock", "correlation", "cosine", "dice", "euclidean", "hamming", "jaccard", "kulsinski", "mahalanobis", "matching", "minkowski", "rogerstanimoto", "russellrao", "seuclidean", "sokalmichener", "sokalsneath", "sqeuclidean", "yule"]
X_projected = mapper.fit_transform(data, projection="sum", scaler=sklearn.preprocessing.MinMaxScaler())

with open('lens.text', 'wb') as abc:
    np.savetxt(abc, X_projected)

graph = mapper.map(X_projected,
                   data,
                   clusterer=sklearn.cluster.DBSCAN(eps=0.1, min_samples=5),
                   coverer=km.Cover(nr_cubes=10, overlap_perc=0.2))

mapper.visualize(graph,
                 path_html=output_Path, custom_tooltips=tooltip_s)