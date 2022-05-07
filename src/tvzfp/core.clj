(ns tvzfp.core
  (:require [faker.name :refer [first-name last-name]]
            [faker.address :refer [street-address city us-state-abbr]]
            [faker.phone-number :refer [phone-numbers]]
            [faker.internet :refer [email]]
            [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(def -header-line
  ["name"
   "phone-number"
   "email"
   "street-address"
   "city"
   "state-abbr"])

(defn -employee-line []
  [(str (first-name) " " (last-name))
   (first (phone-numbers))
   (email)
   (street-address)
   (city)
   (us-state-abbr)])

(defn -csv-data->maps [csv-data]
  (map zipmap
       (->> (first csv-data) ;; First row is the header
            (map keyword) ;; Drop if you want string keys instead
            repeat)
       (rest csv-data)))

(defn dump-to-csv [numlines]
  (with-open [writer (io/writer "resources/data.csv")]
    (csv/write-csv writer
                   (conj
                    (repeatedly numlines -employee-line) -header-line))))

(defn slurp-csv []
  (with-open [reader (io/reader "resources/data.csv")]
    (doall
     (->> (csv/read-csv reader)
          -csv-data->maps))))

(defn current-year []
  (.get (java.time.LocalDate/now) (java.time.temporal.ChronoField/YEAR)))

