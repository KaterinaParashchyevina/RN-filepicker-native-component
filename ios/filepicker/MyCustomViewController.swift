//
//  MyCustomViewController.swift
//  filepicker
//
//

import UIKit
import UniformTypeIdentifiers


class MyCustomViewController: UIViewController, MyCustomViewDelegate, UIDocumentPickerDelegate {
  
  override func viewDidLoad() {
    super.viewDidLoad()
  }
  
  
  override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
    
    let customView = MyCustomView()
    customView.delegate = self
    
  }
  
  
  func buttonClicked(sender: UIButton) {
    print("buttonClicked controller")
    
    if #available(iOS 14.0, *) {
      let types = UTType.types(tag: "json",
                               tagClass: UTTagClass.filenameExtension,
                               conformingTo: nil)
      
      let documentPickerController = UIDocumentPickerViewController(
        forOpeningContentTypes: types)
      documentPickerController.delegate = self
      self.present(documentPickerController, animated: true, completion: nil)
      
    } else {
      //  Fallback; on earlier versions
    }
  }
  
  
}
