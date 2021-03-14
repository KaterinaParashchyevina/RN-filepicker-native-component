//
//  MyCustomView.swift
//  filepicker
//
//
import UIKit
import MobileCoreServices
import UniformTypeIdentifiers



protocol MyCustomViewDelegate : class
{
  func buttonClicked(sender: UIButton)
}


class MyCustomView: UIView
{
  
  
  var filePickerButton: UIButton!
  weak var delegate: MyCustomViewDelegate?
  
  override init(frame: CGRect) {
    super.init(frame: frame)
    setupView()
  }
  
  required init?(coder aDecoder: NSCoder) {
    super.init(coder: aDecoder)
    setupView()
  }
  
  private func setupView() {
    
    filePickerButton = UIButton(type: .system)
    filePickerButton.frame = CGRect(x: 100, y: 100, width: 100, height: 50)
    filePickerButton.backgroundColor = .blue
    filePickerButton.setTitle("Choose file", for: .normal)
    filePickerButton.addTarget(self, action:#selector(self.buttonClicked),
                               for: UIControl.Event.touchUpInside)
    self.addSubview(filePickerButton)
  }
  
  
  @objc func buttonClicked(sender:UIButton)
  {
    if delegate != nil {
      print("buttonClicked")
      
      delegate?.buttonClicked(sender: sender)
    } else {
      print("Please set Delegate")
    }
    
  }
}


