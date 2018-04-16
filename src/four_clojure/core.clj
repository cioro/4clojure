(ns four-clojure.core
  (:gen-class))

(defn my-last 
  "Returns last element of a collection"
  [collection]
  (first (drop (- (count collection) 1) collection)))

(defn my-penultimate
  [collection]
  (first (drop (- (count collection) 2) collection)))

(defn my-nth-element
  "Returns the nth element of a sequence"
  [collection nth-element]
  (first (drop nth-element collection)))

(defn my-count
  "Returns total number of elements in a seq"
  [collection]
  (reduce (fn [result _] (inc result)) 0 collection))

(defn my-reverse
  "Returns a reversed sequence"
  [coll]
  (reduce conj () coll))

(defn only-odds
  "Returns only the odd numbers"
  [coll]
  (filter (fn [x] (not= (mod x 2) 0)) coll))

;; Use scope function for use only once functions or
;; functions that are only used within another function

(defn my-fib
  "Returns the fibonnaci sequence up to the nth-element"
  [nth-element]
  (let [fib (fn fib
              [a b]
              ;; QUESTIONS: why does writing (b) raises an exception?
              ;; Why should I invert the lazy-seq and the cons functions.
              (lazy-seq (cons a (fib b (+ a b)))))]
    (rest  (take (+  nth-element 1) (fib 0 1)))))

(defn my-fib-2
  [nth-element]
  (let [fib-step (fn fib-step [[a b]] [b (+ a b)])
        fib-seq  (fn fib-seq  [] (map first (iterate fib-step [0 1])))]
    (take nth-element (fib-seq))
   ))

(defn strange-count
  [coll]
  (-> coll
      (zipmap (range))
      (last)
      (last)
      (inc)))

(defn palindrome?
  "Returns true is sequence is a palindrom"
  [coll]
  (= (seq  coll) (reverse coll)))

(defn my-flatten
  "Flattens a sequence"
  [coll]
  (filter (complement sequential?)
          (rest (tree-seq sequential? seq coll))))

(defn only-upper-case
  "Returns a string with only the upper case letters"
  [string]
  (reduce str (filter #(Character/isUpperCase %) string)))

(defn only-upper-case-2
  [string]
  (reduce str (re-seq #"[A-Z]" string )))

(defn compress-seq
  "Removes consecutive duplicates from a seq"
  [coll]
  (reduce (fn [acc x]
            (concat acc 
                    (when (not= (last acc) x)
                      [x])))
          []
          coll))

(defn compress-seq-2
  "Removes consecutive duplicates from a seq"
  [coll]
  (reduce (fn [acc x]
            (if (= (last acc) x)
                acc
                (conj acc x)))
          []
          coll))

(defn pack-seq
  "Packs consecutive duplicates into sub-lists"
  [coll]
  (partition-by identity coll))

(defn map-creator
  "Create a map with a given set of keys and default"
  [default-value ks]
  (let [default-values (repeat default-value)]
    (zipmap ks default-values)))

(defn contains-nil-for-key
  [k m]
  (nil? (get m k :not-found)))


(defn duplicates-elements
  "Duplicates every element of input seq"
  [coll]
  (reduce (fn [acc x]
            (conj acc x x))
          []
          coll))

(defn repeat-elements-n-times
  "Creates a new seq where every element is repeat n times"
  [coll n]
  (reduce (fn [acc x]  (concat acc (repeat n x)))
          []
          coll))

(defn my-interpose
  "Separates each item in a sequence by using value v"
  [v coll]
  (rest (#(reduce (fn [acc x] (conj acc %1 x))
                    []
                    %2) v coll)))

(defn my-interleave
  [c1 c2]
  (flatten (map #(concat [%1] [%2]) c1 c2)))
