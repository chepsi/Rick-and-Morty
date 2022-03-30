//
//  CharactersView.swift
//  iosApp
//
//  Created by Evans Chepsiror on 28/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct CharactersView: View {
    var body: some View {
        
        VStack {
            HStack{
                Image("character")
                    .renderingMode(.template)
                    .foregroundColor(ColorManager.primary)
                Spacer()
                Button(action: {
                    
                }) {
                    ZStack {
                        Image("search")
                        Image(systemName: "magnifyingglass")
                            .foregroundColor(.white)
                    }
                }
            }
            .padding()
            Spacer()
            
            Text("Character")
        }
    }
}

struct CharactersView_Previews: PreviewProvider {
    static var previews: some View {
        CharactersView()
    }
}
