//
//  MyCustomViewManager.swift
//  filepicker
//
//  Created by Katerina Parashchyevina on 13.03.2021.
//

@objc (RCTMyCustomViewManager)
class MyCustomViewManager: RCTViewManager {

  override static func requiresMainQueueSetup() -> Bool {
    return true
  }

  override func view() -> UIView! {
    return MyCustomView()
  }

}

