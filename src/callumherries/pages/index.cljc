(ns callumherries.pages.index
  (:require [callumherries.routes :as routes]
            [callumherries.pages.posts :as posts]
            [bidi.bidi :as b]))

(defn hiccup []
  (list
    [:h1 "Callum Herries Hey"]
    [:p "This is an index page and its content is up to you! Also visit "
     [:a {:href (b/path-for routes/routes :page/contact)} "contact page"] "."]
    [:p {:style {:color            "navy"
                 :background-color "lightblue"
                 :padding          5}}
     "You can use any hiccup you want:"]
    [:ul (for [{:keys [title date]} posts/posts]
           [:li
            [:div date [:a {:href "/index.html"} title]]])]))
