# Unix Timestamp Converter API - Ruby Gem

Unix Timestamp Converter converts Unix timestamps into formatted dates and parses ISO 8601 strings back into epoch seconds. Responses break down dates into ISO 8601, RFC 2822, simple time strings, individual calendar components like year, month and hour, plus the day of the year. Paid plans add the ISO week, and an IANA timezone to also get the same moment in local time with its UTC offset, abbreviation and daylight saving flag.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_unixtimestamp'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_unixtimestamp
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_unixtimestamp'

# Initialize the client
client = APIVerve::Unixtimestamp::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  timestamp: "1609459200",
  format: "seconds",
  timezone: "America/New_York"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ timestamp: "1609459200", format: "seconds", timezone: "America/New_York" })
  puts response["data"]
rescue APIVerve::Unixtimestamp::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Unixtimestamp::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Unixtimestamp::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "timestamp": 1609459200,
    "timestamp_format": "seconds",
    "iso_8601": "2021-01-01T00:00:00.000Z",
    "rfc_2822": "Fri, 01 Jan 2021 00:00:00 GMT",
    "date": "1/1/2021",
    "time": "12:00:00 AM",
    "unix_seconds": 1609459200,
    "unix_milliseconds": 1609459200000,
    "year": 2021,
    "month": 1,
    "day": 1,
    "hour": 0,
    "minute": 0,
    "second": 0,
    "day_of_week": "Friday",
    "timezone": "UTC",
    "day_of_year": 1,
    "iso_week": "2020-W53",
    "local": {
      "timezone": "America/New_York",
      "iso_8601": "2020-12-31T19:00:00-05:00",
      "date": "12/31/2020",
      "time": "7:00:00 PM",
      "year": 2020,
      "month": 12,
      "day": 31,
      "hour": 19,
      "minute": 0,
      "second": 0,
      "day_of_week": "Thursday",
      "day_of_year": 366,
      "iso_week": "2020-W53",
      "utc_offset": "-05:00",
      "utc_offset_seconds": -18000,
      "abbreviation": "EST",
      "is_dst": false
    }
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/unixtimestamp?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/unixtimestamp?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/unixtimestamp?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
