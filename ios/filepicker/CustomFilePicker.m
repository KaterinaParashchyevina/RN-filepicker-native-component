#import <React/RCTBridgeModule.h>
#import <React/RCTViewManager.h>

@interface RCTCustomFilePickerViewManager : RCTViewManager
@end


@implementation RCTCustomFilePickerViewManager
RCT_EXPORT_MODULE()
- (UIView *)view
{
  return [[CustomFilePickerView alloc] init];
}
@end
