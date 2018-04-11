(ns four-clojure.core
  (:gen-class))

(defn my-last 
  "Returns last element of a collection"
  [collection]
  (first (drop (- (count collection) 1) collection)))

