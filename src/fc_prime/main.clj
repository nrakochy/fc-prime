(ns fc-prime.main
  (:require [clojure.string :refer [join]]
            [fc-prime.io :as io]
            [fc-prime.core :as core])
  (:gen-class))

(def cell-size 10)

(defn generate-blank-str [size]
  (apply str (repeat size " ")))

(defn cell [content]
  (let [str-content (str content) 
        diff (- cell-size (count str-content))
        prepend (quot diff 2)
        append (- diff prepend)]
    (str (generate-blank-str prepend) str-content (generate-blank-str append))))
    
(defn generate-str-products [multiplier coll]
  (map #(cell (* multiplier %)) coll))

(defn delimited-join [coll]
  (join "|" coll))

(defn generate-product-row [multiplier coll]
  (let [first-column (cell multiplier)]
    (->> (generate-str-products multiplier coll) 
         (apply conj [first-column]) 
         (delimited-join))))

(defn build-multiplication-table []
  (let [primes (core/find-primes)
        empty-cell (generate-blank-str cell-size)
        header-row (delimited-join (into [empty-cell] (map cell primes)))
        break-row (str (apply str (repeat (count header-row) "_")) (System/lineSeparator))]
    (into [header-row break-row] (map #(generate-product-row % primes) primes))))

(defn -main []
  (-> (build-multiplication-table) io/render))
