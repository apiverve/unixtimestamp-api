Pod::Spec.new do |s|
  s.name             = 'APIVerveUnixTimestampConverter'
  s.version          = '1.2.3'
  s.summary          = 'Unix Timestamp Converter converts Unix timestamps into formatted dates and parses ISO 8601 strings back into epoch seconds.'
  s.description      = <<-'DESC'
Unix Timestamp Converter converts Unix timestamps into formatted dates and parses ISO 8601 strings back into epoch seconds. Responses break down dates into ISO 8601, RFC 2822, simple time strings, and individual calendar components like year, month, and hour.

This iOS/macOS SDK provides a convenient way to access the Unix Timestamp Converter from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/unixtimestamp?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/unixtimestamp-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveUnixTimestampConverter/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
