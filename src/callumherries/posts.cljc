(ns callumherries.posts
  (:require [markdown-to-hiccup.core :as m]
            [shadow.resource :as rc]))

;; for more about rc/inline, see
;; https://clojureverse.org/t/using-none-code-resources-in-cljs-builds/3745
(def posts-data
  [{:title    "Test title"
    :date     "2020-01-01"
    :page-key :posts/test
    :url-name "test"
    :md       (rc/inline "./posts/test.md")}])

(def posts
  (->> posts-data
       (map #(assoc % :hiccup (-> % :md m/md->hiccup m/component)))))

(defn post-page [post]
  (drop 2 post))
