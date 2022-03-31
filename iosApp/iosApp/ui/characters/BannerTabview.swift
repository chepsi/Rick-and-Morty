//
//  BannerTabview.swift
//  iosApp
//
//  Created by Le Bon B' Bauma on 31/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct BannerTabview: View {
    var body: some View {
        
        TabView {
            ForEach(banners) { banner in
                BannerItemView(banner: banner)
                //                    .padding(.top, 10)
                //                    .padding(.horizontal, 15)
                //                    .padding(.bottom, 10)
                
            }//: LOOP
        } //: TAB
        .tabViewStyle(PageTabViewStyle(indexDisplayMode: .always))
    }
}

struct BannerTabview_Previews: PreviewProvider {
    static var previews: some View {
        BannerTabview()
    }
}
