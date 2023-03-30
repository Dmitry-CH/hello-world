(ns helloworld.pages.home.view
  (:require [rum.core :as rum]
            [helloworld.pages.layout :as layout]
            [helloworld.pages.ui.button.core :refer [button-square]]))


(rum/defc about [map]
  [:dl#js-splitting.grid.gap-0.lg:gap-4.text-base.lg:text-2xl.uppercase
   {:class "grid-cols-[1fr] lg:grid-cols-[15ch_1fr] lg:max-w-[50%]"}

   (for [[_ val] map]
     [:<>
      [:dt.font-bold (:title val)]
      [:dd.mb-3.lg:mb-0.last:mb-0 (:value val)]])])


(rum/defc body [{:keys [lang loading title content]}]
  [:div.loading
   [:div.absolute.top-0.w-full.py-3.hidden
    [:div.container.flex.items-center.justify-between
     [:span.text-sm.leading-8.text-lime-500 loading]]]

   [:header.absolute.top-0.w-full.py-3
    [:div.container.flex.items-center.justify-between
     [:h2.text-sm.text-lime-500 title]
     (button-square lang {:hx-get "/api/lang"})]]

   [:main.overflow-hidden
    [:div.container.flex.items-center.h-screen
     (about content)]]

   [:footer.absolute.bottom-0.w-full.py-3
    [:div.container.flex.items-center.justify-end
     [:time#js-time.text-sm.text-lime-500
      0]]]])


(defn render [{:keys [lang tr]}]
  (let [data {:lang  (tr [:page/lang])
              :loading (tr [:page/loading])
              :title (tr [:page/title])
              :content {:name {:title (tr [:author.name/title])
                               :value (tr [:author.name/value])}
                        :profession {:title (tr [:author.profession/title])
                                     :value (tr [:author.profession/value])}
                        :bio {:title (tr [:author.bio/title])
                              :value (tr [:author.bio/value])}}}
        body (rum/render-static-markup (body data))]

    (layout/render {:lang lang
                    :body body})))
