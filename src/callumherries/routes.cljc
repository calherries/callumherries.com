(ns callumherries.routes
  (:require [callumherries.pages.posts :as posts]))

(def posts-routes
  ["posts/" (into []
                  (for [{:keys [page-key]} posts/posts]
                    [(str (name page-key) ".html") page-key]))])

(def routes
  ["/" [["index.html" :page/index]
        ["contact.html" :page/contact]
        posts-routes]])
