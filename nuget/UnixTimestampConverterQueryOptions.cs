using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.UnixTimestampConverter
{
    /// <summary>
    /// Query options for the Unix Timestamp Converter API
    /// </summary>
    public class UnixTimestampConverterQueryOptions
    {
        /// <summary>
        /// Unix timestamp to convert (provide either timestamp or date)
        /// Example: 1609459200
        /// </summary>
        [JsonProperty("timestamp")]
        public string Timestamp { get; set; }

        /// <summary>
        /// Date string to convert (provide either timestamp or date)
        /// Example: 2021-01-01T00:00:00Z
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// Timestamp format: 'seconds', 'milliseconds', 's', or 'ms' (default: seconds)
        /// Example: seconds
        /// </summary>
        [JsonProperty("format")]
        public string Format { get; set; }
    }
}
