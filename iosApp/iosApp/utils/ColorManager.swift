//
//  ColorManager.swift
//  iosApp
//
//  Created by Le Bon B' Bauma on 29/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct ColorManager {

    static let primary = Color("PrimaryColor")
    static let secondary = Color("SecondaryColor")

    
}

extension UIColor {
    class var primaryColor: UIColor {
        return UIColor(named: "PrimaryColor")!
    }
    class var secondaryColor: UIColor {
        return UIColor(named: "SecondaryColor")!
    }
}
