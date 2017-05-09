(ns fc-prime.main
  (:require [clojure.string :refer [join]]
            [fc-prime.io :as io]
            [fc-prime.core :as core]))

(defn generate-str-products [multiplier coll]
  (map #(str (* multiplier %)) coll))

(defn delimited-join [coll]
  (join "|" coll))

(defn generate-product-row [multiplier coll]
    (->> (generate-str-products multiplier coll) (apply conj [multiplier]) (delimited-join)))

(defn build-multiplication-table []
  (let [primes (core/find-primes)
        empty-space "        "
        header-row (delimited-join (apply conj [empty-space] primes))]
    (into [header-row] (map #(generate-product-row % primes) primes))))

(defn main []
  (-> (build-multiplication-table) io/render))
