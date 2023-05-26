//
//  BannerItemView.swift
//  iosApp
//
//  Created by Le Bon B' Bauma on 31/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct BannerItemView: View {
    
    let banner: Banner
    
    var body: some View {
        Image(banner.image)
            .resizable()
            .scaledToFit()
    }
}

struct BannerItemView_Previews: PreviewProvider {
    static var previews: some View {
        BannerItemView(banner: banners[0])
    }
}
